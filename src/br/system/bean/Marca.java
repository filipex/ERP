
package br.system.bean;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 22/12/2011 22:37
 */

@Entity
public class Marca implements Serializable {

    @Id
    @SequenceGenerator(name="marca_id_seq", sequenceName="hibernate_marca", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="marca_id_seq")
    private Long mrc_codigo;

    private String mrc_descricao;

    public Marca() {

    }

    public Marca(Long mrc_codigo, String mrc_descricao) {
        this.mrc_codigo = mrc_codigo;
        this.mrc_descricao = mrc_descricao;
    }

    @Override
    public String toString() {
        return mrc_descricao;
    }

}