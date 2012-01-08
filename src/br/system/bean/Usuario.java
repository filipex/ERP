
package br.system.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 11/12/2011 10:29
 */

@Entity
public class Usuario implements Serializable {

    @Id
    @SequenceGenerator(name="usuario_id_seq", sequenceName="hibernate_usuario", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="usuario_id_seq")
    private Long user_id;

    private String user_nome;

    private String user_sobrenome;

    private String user_cpf;

    private String user_numendereco;

    private String user_login;

    private String user_senha;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date user_datanascimento;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Endereco> endereco;

    public Usuario() { 
    
    }

    public Usuario(Long user_id, String user_nome, String user_sobrenome, String user_cpf, String user_numendereco, String user_login, String user_senha, String user_complemento) {
        this.user_id = user_id;
        this.user_nome = user_nome;
        this.user_sobrenome = user_sobrenome;
        this.user_cpf = user_cpf;
        this.user_numendereco = user_numendereco;
        this.user_login = user_login;
        this.user_senha = user_senha;
    }

    @Override
    public String toString() {
        return user_nome + " " + user_sobrenome;
    }

}
