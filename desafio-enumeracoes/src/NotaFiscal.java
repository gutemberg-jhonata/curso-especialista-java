public class NotaFiscal {

    private enum Status {
        NAO_EMITIDA("Não emitida") {

            @Override
            public boolean podeEmitir() {
                return true;
            }

            @Override
            public boolean podeCancelar(double valor) {
                return true;
            }

        }, 
        
        EMITIDA("Emitida") {
            
            @Override
            public boolean podeEmitir() {
                return false;
            }

            @Override
            public boolean podeCancelar(double valor) {
                return valor < 1_000;
            }

        }, 
        
        CANCELADA("Cancelada") {

            @Override
            public boolean podeEmitir() {
                return false;
            }

            @Override
            public boolean podeCancelar(double valor) {
                return false;
            }

        };

        private String descricao;

        public String getDescricao() {
            return descricao;
        }

        Status(String descricao) {
            this.descricao = descricao;
        }

        public abstract boolean podeCancelar(double valor);
        public abstract boolean podeEmitir();
    }

    private final Integer numero;
    private final String descricao;
    private final double valor;
    private Status status = Status.NAO_EMITIDA;

    public NotaFiscal(Integer numero, String descricao, double valor) {
        this.numero = numero;
        this.descricao = descricao;
        this.valor = valor;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public Status getStatus() {
        return status;
    }

    public void cancelar() {
        if (status.podeCancelar(getValor())) {
            status = Status.CANCELADA;
        } else {
            throw new IllegalStateException("Não foi possível cancelar a nota fiscal");
        }
    }

    public void emitir() {
        if (status.podeEmitir()) {
            status = Status.EMITIDA;            
        } else {
            throw new IllegalStateException("Não foi possível emitir a nota fiscal");
        }
    }

    public String getDescricaoCompleta() {
        return String.format("Nota fiscal #%d (%s) no valor de R$%.2f está %s",
                getNumero(), getDescricao(), getValor(), getStatus().getDescricao());
    }

}
