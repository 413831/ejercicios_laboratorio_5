package utn.sistema.practica_primer_parcial.clases;

public enum TipoUsuario
{
    USUARIO("User"),
    ADMINISTRADOR("Admin");

    private final String perfil;

    TipoUsuario(String perfil)
    {
        this.perfil = perfil;
    }

    @Override
    public String toString()
    {
        return this.perfil;
    }

    public String getPerfil() {
        return perfil;
    }


}
