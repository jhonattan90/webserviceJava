package br.edu.opet.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import br.edu.opet.model.Chamado;

@XmlRootElement(name = "ChamadoDTO")
public class ChamadoDTO extends AbstractDTO<Chamado>
{
    /* Construtores da classe */
    public ChamadoDTO()
    {
        super();
    }

    public ChamadoDTO(boolean pOk, String pMensagem)
    {
        super(pOk, pMensagem);
    }

    public ChamadoDTO(boolean pOk, String pMensagem, Chamado pChamado)
    {
        super(pOk, pMensagem, pChamado);
    }

    public ChamadoDTO(boolean pOk, String pMensagem, List<Chamado> pLista)
    {
        super(pOk, pMensagem, pLista);
    }

    /* Métodos de acesso */
    public Chamado getChamado()
    {
        return getObjeto();
    }

    public void setChamado(Chamado pChamado)
    {
        setObjeto(pChamado);
    }
}