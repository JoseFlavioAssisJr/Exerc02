package Reclamação;

public class Reclamação {
    
    private Long id;
    private String nome;
    private String email;
    private String descricao;
    private int status;
    
    public Reclamação() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getStatus() {
        return status;
    }
    
    public String getStatusTexto() {
        switch (this.getStatus()) {
            case 0:
                return "Aberto";
            case 1:
                return "Aberto";
            case 2:
                return "Aberto";
            case 3:
                return "Aberto";
            case 4:
                return "Aberto";
            default:
                return "??";
        }
    }
    
    public void setStatus(int status) {
        this.status = status;
    }
      
}
