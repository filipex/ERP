
package br.system.bean;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
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
 * @since 22/12/2011 22:41
 */

@Entity
public class Grupo implements Serializable {

    @Id
    @SequenceGenerator(name="grupo_id_seq", sequenceName="hibernate_grupo", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="grupo_id_seq")
    private Long grup_id;

    private int grup_cod;

    private String grup_descricao;

    @Temporal(javax.persistence.TemporalType.TIMESTAMP)    
    private Date grup_dataregistro;

    public Grupo() {
        
    }

    public Grupo(Long grup_id, int grup_cod, String grup_descricao, Date grup_dataregistro) {
        this.grup_id = grup_id;
        this.grup_cod = grup_cod;
        this.grup_descricao = grup_descricao;
        this.grup_dataregistro = grup_dataregistro;
    }

    @Override
    public String toString() {
        return grup_descricao;
    }

}