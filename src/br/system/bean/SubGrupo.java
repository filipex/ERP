
package br.system.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 22:45
 */

@Entity
public class SubGrupo implements Serializable {

    @Id
    @SequenceGenerator(name="subgrupo_id_seq", sequenceName="hibernate_subgrupo", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="subgrupo_id_seq")
    private Long subgrup_id;

    private int subgrup_cod;

    private String subgrup_descricao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date subgrup_dataregistro;

    public SubGrupo() {
    }

    public SubGrupo(Long subgrup_id, int subgrup_cod, String subgrup_descricao, Date subgrup_dataregistro) {
        this.subgrup_id = subgrup_id;
        this.subgrup_cod = subgrup_cod;
        this.subgrup_descricao = subgrup_descricao;
        this.subgrup_dataregistro = subgrup_dataregistro;
    }

    @Override
    public String toString() {
        return subgrup_descricao;
    }

}
