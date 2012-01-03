
package br.system.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 22:02
 */

@Entity
public class Empresa implements Serializable {

    @Id
    @SequenceGenerator(name="empresa_id_seq", sequenceName="hibernate_empresa", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="empresa_id_seq")
    private Long emp_filial;

    private String emp_razaosocial;

    private String emp_fantasia;

    private String emp_cnpj;

    private String emp_inscestadual;

    private int emp_numendereco;

    private String emp_complemento;

    private String emp_fone;

    private String emp_fone2;

    private String emp_celular;

    @OneToMany(mappedBy = "empresa", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Endereco> endereco;

    public Empresa() {

    }

    public Empresa(Long emp_filial, String emp_razaosocial, String emp_fantasia, String emp_cnpj, String emp_inscestadual, int emp_numendereco, String emp_complemento, String emp_fone, String emp_fone2, String emp_celular, List<Endereco> endereco) {
        this.emp_filial = emp_filial;
        this.emp_razaosocial = emp_razaosocial;
        this.emp_fantasia = emp_fantasia;
        this.emp_cnpj = emp_cnpj;
        this.emp_inscestadual = emp_inscestadual;
        this.emp_numendereco = emp_numendereco;
        this.emp_complemento = emp_complemento;
        this.emp_fone = emp_fone;
        this.emp_fone2 = emp_fone2;
        this.emp_celular = emp_celular;
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return emp_razaosocial;
    }
}