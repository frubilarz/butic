/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boaboa.org.butic.servicio;

import boaboa.org.butic.model.Boleta;
import boaboa.org.butic.model.Cliente;
import boaboa.org.butic.model.Local;
import boaboa.org.butic.model.Producto;
import boaboa.org.butic.model.Usuario;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author frubilar
 */
public class ServicioDB implements Serializable {

    private boolean conectado = false;
    private Connection conexion = null;
    private static Logger logger = LoggerFactory.getLogger(ServicioDB.class);

    @PostConstruct
    public void iniciar() {
        boolean ok = conectar();
        if (!ok) {
            logger.info("ERROR: no fue posible conectarme a la base de datos");
        }

    }

    boolean conectar() {
        this.conectado = false;
        try {
            String url = "jdbc:mysql://127.0.0.1:3333/buticdb?zeroDateTimeBehavior=convertToNull";
            Properties props = new Properties();
            props.setProperty("user", "root");
            props.setProperty("password", "root");
//            props.setProperty("ssl", "true");
            this.conexion = DriverManager.getConnection(url, props);

            if (conexion != null) {
                this.conectado = true;
            } else {
                this.conectado = false;
            }

            if (!conectado) {
                throw new RuntimeException("No se puede conectar al motor de base de datos.");
            }

        } catch (Exception e) {
            this.conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    boolean desconectar() {
        try {
            if (conexion != null) {
                conexion.close();
                conexion = null;
                conectado = false;
            } else {
                conectado = false;
            }
        } catch (Exception e) {
            conexion = null;
            conectado = false;
            logger.error(e.toString());
            logger.debug("Error al conectar con Base de datos", e.toString());
        }
        return conectado;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

    @PreDestroy
    public void finalizar() {
        boolean desconectar = desconectar();
        if (desconectar) {
            logger.info("ERROR: conexión aún activa");
        }
    }

    public List<Boleta> getBoleta(Local local) {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
            if (local != null) {
                if (!isConectado()) {
                    conectar();
                }
                String query = "select b.* from boletas b inner join locales on locales.id= b.local_id and locales.id = ?";
                PreparedStatement st = null;
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, local.getId());
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        while (rs.next()) {
                            Boleta boleta = new Boleta();
                            boleta.setId(rs.getInt("id"));
                            boleta.setMonto(rs.getDouble("monto"));
                            boleta.setLocal_id(rs.getInt("local_id"));
                            boleta.setFecha(rs.getDate("fecha"));

                            boletas.add(boleta);
                        }
                        rs.close();
                    }
                    st.close();
                }
            }
        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.error("Error al intentar obtener una boleta por local: {}", e.toString());
            logger.debug("Error al intentar obtener una boleta por local: {}", e.toString(), e);
        }
        return boletas;
    }

    public Usuario getUsuario(Integer rut) {
        Usuario usuario = null;
        try {
            if (rut != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "select * from usuarios where rut = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            usuario = new Usuario();
                            usuario.setId(rs.getInt("id"));
                            usuario.setClave(rs.getString("clave"));
                            usuario.setNombre(rs.getString("nombre"));
                            usuario.setRut(rs.getInt("rut"));
                        }
                        rs.close();
                    }
                    st.close();
                }
            }
        } catch (Exception e) {
        }
        return usuario;
    }

    public Producto getProducto(String codigo) {
        Producto producto = null;
        try {
            if (StringUtils.isNotEmpty(codigo)) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "select * from productos where codigo = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setString(1, codigo);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            producto = new Producto();
                            producto.setId(rs.getInt("id"));
                            producto.setCodigo(rs.getString("codigo"));
                            producto.setNombre(rs.getString("nombre"));
                            producto.setStock(rs.getInt("stock"));
                            producto.setValor(rs.getFloat("valor"));
                        }
                        rs.close();
                    }
                    st.close();
                }
            }
        } catch (Exception e) {
            producto = null;
            logger.error("Error al intentar buscar un producto por codigo: {}", e.toString());
            logger.debug("Error al intentar buscar un producto por codigo: {}", e.toString(), e);
        }
        return producto;
    }

    public Boleta getBoleta(Integer id) {
        Boleta boleta = null;
        try {
            if (id != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "select * from boletas where id = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);
                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            boleta = new Boleta();
                            boleta.setId(rs.getInt("id"));
                            boleta.setMonto(rs.getDouble("monto"));
                            boleta.setLocal_id(rs.getInt("local_id"));
                            boleta.setFecha(rs.getDate("fecha"));
                        }
                        rs.close();
                    }
                    st.close();
                }
            }
        } catch (Exception e) {
            boleta = null;
            logger.debug("Error al intentar obtener boleta por id: {}", e.toString(), e);
            logger.error("Error al intentar obtener boleta por id: {}", e.toString());
        }
        return boleta;
    }

    public List<Boleta> getBoletas() {
        List<Boleta> boletas = new ArrayList<Boleta>();
        try {
            if (!isConectado()) {
                conectar();
            }
            PreparedStatement st = null;
            String query = "SELECT * FROM boletas ";
            st = conexion.prepareStatement(query);
            if (st != null) {
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Boleta boleta = new Boleta();
                        boleta.setId(rs.getInt("id"));
                        boleta.setMonto(rs.getDouble("monto"));
                        boleta.setLocal_id(rs.getInt("local_id"));
                        boleta.setFecha(rs.getDate("fecha"));

                        boletas.add(boleta);
                    }
                    rs.close();
                }
                st.close();
            }
        } catch (Exception e) {
            boletas = new ArrayList<Boleta>();
            logger.error("Error al intentar obtener todas las boletas: {}", e.toString());
            logger.debug("Error al intentar obtener todas las boletas: {}", e.toString(), e);
        }
        return boletas;
    }

    public boolean guardar(Boleta boleta) {
        boolean salida = false;
        try {
            if (boleta != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (boleta.getId() != null) {
                    if (boleta.getId() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE boletas SET monto=?, local_id=? WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setDouble(1, boleta.getMonto());
                    st.setInt(2, boleta.getLocal_id());
                    st.setInt(3, boleta.getId());
                } else {
                    query = "INSERT INTO boletas (monto,local_id,fecha) VALUES (?,?,?)";
                    st = conexion.prepareStatement(query);

                    st.setDouble(1, boleta.getMonto());
                    st.setInt(2, boleta.getLocal_id());
                    st.setDate(3, (Date) boleta.getFecha());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }

            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar  persisitir: {}", e.toString(), e);
            logger.error("error al intentar persisitir: {}", e.toString());
        }
        return salida;
    }

    public boolean guardar(Producto producto) {
        boolean salida = false;
        try {
            if (producto != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (producto.getId() != null) {
                    if (producto.getId() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE productos SET nombre=?, codigo=?,stock=?, valor=? WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, producto.getNombre());
                    st.setString(2, producto.getCodigo());
                    st.setInt(3, producto.getStock());
                    st.setFloat(4, producto.getValor());
                    st.setInt(5, producto.getId());
                } else {
                    query = "INSERT INTO productos (nombre,codigo,stock,valor) VALUES (?,?,?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, producto.getNombre());
                    st.setString(2, producto.getCodigo());
                    st.setInt(3, producto.getStock());
                    st.setFloat(4, producto.getValor());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }

            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar  persisitir: {}", e.toString(), e);
            logger.error("error al intentar persisitir: {}", e.toString());
        }
        return salida;
    }

    public boolean guardar(Usuario usuario) {
        boolean salida = false;
        try {
            if (usuario != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (usuario.getId() != null) {
                    if (usuario.getId() > 0) {
                        update = true;
                    }
                }

                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE usuarios SET nombre=?,clave=? WHERE rut = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, usuario.getNombre());
                    st.setString(2, usuario.getClave());
                    st.setInt(3, usuario.getRut());

                } else {
                    query = "INSERT INTO usuarios (nombre, rut,clave) VALUES (?, ?, ?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, usuario.getNombre());
                    st.setInt(2, usuario.getRut());
                    st.setString(3, usuario.getClave());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }
            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar persistir un usuario : {}", e.toString(), e);
            logger.error("Error al intentar persistir un usuario : {}", e.toString());
        }
        return salida;
    }

    public boolean guardar(Cliente cliente) {
        boolean salida = false;
        try {
            if (cliente != null) {
                if (!isConectado()) {
                    conectar();
                }
                boolean update = false;
                if (cliente.getId() != null) {
                    if (cliente.getId() > 0) {
                        update = true;
                    }
                }
                PreparedStatement st = null;
                String query = "";
                if (update) {
                    query = "UPDATE clientes SET nombre=?, rut=? ,fono=?, mail=?, direccion=? WHERE id = ?";
                    st = conexion.prepareStatement(query);
                    st.setString(1, cliente.getNombre());
                    st.setInt(2, cliente.getRut());
                    st.setInt(3, cliente.getFono());
                    st.setString(4, cliente.getEmail());
                    st.setString(5, cliente.getDireccion());
                    st.setInt(6, cliente.getId());

                } else {
                    query = "INSERT INTO clientes (nombre, rut, fono,mail,direccion) VALUES (?, ?, ?, ?,?)";
                    st = conexion.prepareStatement(query);
                    st.setString(1, cliente.getNombre());
                    st.setInt(2, cliente.getRut());
                    st.setInt(3, cliente.getFono());
                    st.setString(4, cliente.getEmail());
                    st.setString(5, cliente.getDireccion());
                }
                if (st != null) {
                    logger.info(st.toString());
                    st.execute();

                    int updateCount = st.getUpdateCount();
                    if (updateCount > 0) {
                        salida = true;
                    }
                }
            }

        } catch (Exception e) {
            salida = false;
            logger.debug("error : {}", e.toString(), e);
            logger.error("Error : {}", e.toString());
        }
        return salida;
    }

    public Cliente getCliente(Integer id) {
        Cliente cliente = null;
        try {
            if (id != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM clientes WHERE id = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, id);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            cliente = new Cliente();
                            cliente.setDireccion(rs.getString("direccion"));
                            cliente.setEmail(rs.getString("mail"));
                            cliente.setFono(rs.getInt("fono"));
                            cliente.setNombre(rs.getString("nombre"));
                            cliente.setRut(rs.getInt("rut"));
                            cliente.setId(rs.getInt("id"));

                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            cliente = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return cliente;
    }

    public Cliente getClientePorRut(Integer rut) {
        Cliente cliente = null;
        try {
            if (rut != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "SELECT * FROM clientes WHERE rut = ?";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            cliente = new Cliente();
                            cliente.setDireccion(rs.getString("direccion"));
                            cliente.setEmail(rs.getString("mail"));
                            cliente.setFono(rs.getInt("fono"));
                            cliente.setNombre(rs.getString("nombre"));
                            cliente.setRut(rs.getInt("rut"));
                            cliente.setId(rs.getInt("id"));

                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            cliente = null;
            logger.debug("Error al intentar obtener cliente por id : {}", e.toString(), e);
            logger.error("Error al intentar obtener cliente por id : {}", e.toString());
        }
        return cliente;
    }

    public List<Cliente> getClientes() {
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            if (!isConectado()) {
                conectar();
            }
            PreparedStatement st = null;
            String query = "SELECT * FROM clientes ";
            st = conexion.prepareStatement(query);
            if (st != null) {
                ResultSet rs = st.executeQuery();
                if (rs != null) {
                    while (rs.next()) {
                        Cliente cliente = new Cliente();

                        cliente.setId(rs.getInt("id"));
                        cliente.setDireccion(rs.getString("direccion"));
                        cliente.setEmail(rs.getString("mail"));
                        cliente.setFono(rs.getInt("fono"));
                        cliente.setNombre(rs.getString("nombre"));
                        cliente.setRut(rs.getInt("rut"));

                        clientes.add(cliente);
                    }
                    rs.close();
                }
                st.close();
            }

        } catch (Exception e) {
            clientes = new ArrayList<Cliente>();
            logger.debug("Error al intentar obtener todos los clientes: {}", e.toString(), e);
            logger.error("Error al intentar obtener todos los clientes: {}", e.toString());
        }
        return clientes;
    }

    public boolean verificarAdmin(Integer rut){
        boolean salida = false;
        try {
            if (rut != null) {
                if (!isConectado()) {
                    conectar();
                }
                PreparedStatement st = null;
                String query = "select u.* from  usuarios u join roles on u.rol_id = roles.id "
                        + " where roles.nombre = 'admin' and u.rut = ? ";
                st = conexion.prepareStatement(query);
                if (st != null) {
                    st.setInt(1, rut);

                    ResultSet rs = st.executeQuery();
                    if (rs != null) {
                        if (rs.next()) {
                            salida = true;
                        }
                        rs.close();
                    }
                    st.close();
                }

            }
        } catch (Exception e) {
            salida = false;
            logger.debug("Error al intentar obtener usuario Con rol Admin : {}", e.toString(), e);
            logger.error("Error al intentar obtener Usuario con rol Admin : {}", e.toString());
        }
            
        return salida;
    }
    
}
