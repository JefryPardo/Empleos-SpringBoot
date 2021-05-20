package net.itinajero.model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="Usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;
    private String username;
    private String nombre;
    private String email;
    private String password;
    private int estatus;
    private Date fechaRegistro;
    
    //Configuracion de muchos a muchos
    @ManyToMany(fetch = FetchType.EAGER)//Esta anotacion trae todos los perfiles asociados con dicho usuario
    @JoinTable(
        name = "UsuarioPerfil",
        joinColumns = @JoinColumn(name="idUsuario"), //En este parametro pasamos idUsuario porque estamos actualmente en esta clase
        inverseJoinColumns = @JoinColumn(name="idPerfil")//EN este caso el nombre de la llave FK de la otra tabla
        )
    private List<Perfil> perfiles;


    public void agregar(Perfil tempPerfil){
        if(perfiles == null){
            perfiles = new LinkedList<Perfil>();
        }
        perfiles.add(tempPerfil);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getEstatus() {
        return estatus;
    }
    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    public List<Perfil> getPerfiles() {
        return perfiles;
    }
    public void setPerfiles(List<Perfil> perfiles) {
        this.perfiles = perfiles;
    }
    @Override
    public String toString() {
        return "Usuario [email=" + email + ", estatus=" + estatus + ", fechaRegistro=" + fechaRegistro + ", id=" + id
                + ", nombre=" + nombre + ", password=" + password + ", perfiles=" + perfiles + ", username=" + username
                + "]";
    }
    
    
}
