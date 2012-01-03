
package br.system.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Entity;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 21/12/2011 19:30
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(name="cliente_id_seq", sequenceName="hibernate_cliente", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cliente_id_seq")
    private Long cln_codigo;

    private String cln_nome;

    private String cln_sobrenome;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date cln_datanascimento;

    private String cln_cpfcnpj;

    private String cln_rg;

    private String cln_orgaoexpeditor;

    private String cln_inscestadual;

    private String cln_numendereco;

    private String cln_complemento;

    private String cln_observacao;

    private String cln_fone;

    private String cln_fone2;

    private String cln_celular;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Endereco> endereco;

    private Cliente() {

    }

    public Cliente(Long cln_codigo, String cln_nome, String cln_sobrenome, Date cln_datanascimento, String cln_cpfcnpj, String cln_rg, String cln_orgaoexpeditor, String cln_inscestadual, String cln_numendereco, String cln_complemento, String cln_observacao, String cln_fone, String cln_fone2, String cln_celular, List<Endereco> endereco) {
        this.cln_codigo = cln_codigo;
        this.cln_nome = cln_nome;
        this.cln_sobrenome = cln_sobrenome;
        this.cln_datanascimento = cln_datanascimento;
        this.cln_cpfcnpj = cln_cpfcnpj;
        this.cln_rg = cln_rg;
        this.cln_orgaoexpeditor = cln_orgaoexpeditor;
        this.cln_inscestadual = cln_inscestadual;
        this.cln_numendereco = cln_numendereco;
        this.cln_complemento = cln_complemento;
        this.cln_observacao = cln_observacao;
        this.cln_fone = cln_fone;
        this.cln_fone2 = cln_fone2;
        this.cln_celular = cln_celular;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return cln_nome + " " + cln_sobrenome;
    }
}