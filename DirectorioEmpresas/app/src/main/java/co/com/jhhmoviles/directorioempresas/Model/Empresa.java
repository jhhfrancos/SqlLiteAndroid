package co.com.jhhmoviles.directorioempresas.Model;


public class Empresa {
    private long empresaId;
    private String nombre;
    private String url;
    private String telefonoContacto;
    private String eMail;
    private String productosServicios;
    private String clasificacion;

    public Empresa(long empresaId, String nombre, String url, String telefonoContacto, String eMail, String productosServicios, String clasificacion) {
        this.empresaId = empresaId;
        this.nombre = nombre;
        this.url = url;
        this.telefonoContacto = telefonoContacto;
        this.eMail = eMail;
        this.productosServicios = productosServicios;
        this.clasificacion = clasificacion;
    }
    public Empresa(){

    }
    public long getEmpresaId() {
        return empresaId;
    }

    public void setEmpresaId(long empresaId) {
        this.empresaId = empresaId;
    }

    @Override
    public String toString() {
        return "Empresa[" +
                "empresaId=" + empresaId +
                ", nombre=" + nombre +
                ", url=" + url +
                ", telefonoContacto=" + telefonoContacto +
                ", eMail=" + eMail +
                ", productosServicios=" + productosServicios +
                ", clasificacion=" + clasificacion +
                ']';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getProductosServicios() {
        return productosServicios;
    }

    public void setProductosServicios(String productosServicios) {
        this.productosServicios = productosServicios;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }
}
