
package br.system.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 28/11/2011 23:03
 */

@Entity
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name="cidade_id_seq", sequenceName="hibernate_cidade", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cidade_id_seq")
    private Long cdd_id;

    private String cdd_codigo;

    private String cdd_descricao;
    
    private String cdd_uf;

    @ManyToOne
    @JoinColumn(name="end_cep")
    private Endereco endereco;

    public Cidade() {
        // Não implementado
    }

    public Cidade(Long cdd_id, String cdd_codigo, String cdd_descricao, String cdd_uf) {
        this.cdd_id = cdd_id;
        this.cdd_codigo = cdd_codigo;
        this.cdd_descricao = cdd_descricao;
        this.cdd_uf = cdd_uf;
    }

    @Override
    public String toString() {
        return cdd_descricao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCdd_codigo() {
        return cdd_codigo;
    }

    public void setCdd_codigo(String cdd_codigo) {
        this.cdd_codigo = cdd_codigo;
    }

    public String getCdd_descricao() {
        return cdd_descricao;
    }

    public void setCdd_descricao(String cdd_descricao) {
        this.cdd_descricao = cdd_descricao;
    }

    public Long getCdd_id() {
        return cdd_id;
    }

    public void setCdd_id(Long cdd_id) {
        this.cdd_id = cdd_id;
    }

    public String getCdd_uf() {
        return cdd_uf;
    }

    public void setCdd_uf(String cdd_uf) {
        this.cdd_uf = cdd_uf;
    }
}