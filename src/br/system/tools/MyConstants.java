
package br.system.tools;

/**
 *
 * @author Filipe
 * @version 1.0
 * @since 24/12/2011 18:40
 */

public class MyConstants {

    // Atributos de tabelas
    public static final String PARAMETRO_ID_CIDADE = "cdd_id";
    public static final String PARAMETRO_ID_CLIENTE = "cln_codigo";
    public static final String PARAMETRO_ID_EMPRESA = "emp_filial";
    public static final String PARAMETRO_ID_ENDERECO = "end_cep";
    public static final String PARAMETRO_ID_GRUPO = "grup_id";
    public static final String PARAMETRO_ID_MARCA = "mrc_codigo";
    public static final String PARAMETRO_ID_SUBGRUPO = "subgrup_id";
    public static final String PARAMETRO_ID_USUARIO = "user_id";

    // Mensagens de erro
    public static final String ERRO_INSERIR = "Não foi possível salvar o registro, devido a erros.";
    public static final String ERRO_EXCLUIR = "Não foi possível excluir o registro, devido a erros.";
    public static final String ERRO_PESQUISAR = "Não foi possível pesquisar o registro, devido a erros.";
    public static final String ERRO_LISTAR = "Não foi possível carregar todos os registros, devido a erros.";

    // Tipo de Mensagem
    public static final int MENSAGEM_ERRO = 0;
    public static final int MENSAGEM_INFORMACAO = 1;
    public static final int MENSAGEM_ATENCAO = 2;
    public static final int MENSAGEM_QUESTAO = 3;


}
