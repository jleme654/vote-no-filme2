package model;

import java.io.Serializable;
import java.util.Map;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "user")
@SessionScoped
public class User implements Serializable {

    public String nome;
    public String email;

    public String outcome() throws Exception {

        FacesContext fc = FacesContext.getCurrentInstance();

        if (this.nome.equals("")) {
            fc.addMessage("mensagensErro", new FacesMessage("Preencher o campo Nome!"));

            return "finalizacao";

        } else if (this.email.equals("")) {
            fc.addMessage("mensagensErro", new FacesMessage("Preencher o campo Email!"));

            return "finalizacao";
        }

        return "result";
    }

    public String getCountryParam(FacesContext fc) {
        Map<String, String> params = fc.getExternalContext().getRequestParameterMap();

        return params.get("nome");

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}