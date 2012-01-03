
package br.system.bean;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 11/12/2011 10:54
 */

@Entity
public class Endereco implements Serializable {

    @Id
    private String end_cep;

    private String end_descricao;

    private String end_bairro;

    private String end_tipologradouro;

    @OneToMany(mappedBy = "endereco", fetch = FetchType.LAZY)
    @Cascade(CascadeType.ALL)
    private List<Cidade> cidade;

    @ManyToOne
    @JoinColumn(name="user_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="cln_id")
    private Cliente cliente;

    public Endereco() {

    }

    public Endereco(String end_cep, String end_descricao, String end_bairro, String end_tipologradouro, List<Cidade> cidade) {
        this.end_cep = end_cep;
        this.end_descricao = end_descricao;
        this.end_bairro = end_bairro;
        this.end_tipologradouro = end_tipologradouro;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return end_descricao;
    }

}