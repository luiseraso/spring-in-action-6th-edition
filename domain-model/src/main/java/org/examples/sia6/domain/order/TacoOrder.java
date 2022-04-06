package org.examples.sia6.domain.order;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TacoOrder implements Serializable {

    private String tacos;
    private int quantity;
    private LocalDateTime date;

    public TacoOrder() {
    }

    public TacoOrder(String tacos, int quantity, LocalDateTime date) {
        this.tacos = tacos;
        this.quantity = quantity;
        this.date = date;
    }

    @Override
    public String toString() {
        return "TacoOrder{" +
                "tacos='" + tacos + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }

    // Builder
    public static final class Builder {
        private String tacos;
        private int quantity;
        private LocalDateTime date;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder from(TacoOrder order) {
            this.tacos = order.tacos;
            this.quantity = order.quantity;
            this.date = order.date;
            return this;
        }

        public Builder tacos(String tacos) {
            this.tacos = tacos;
            return this;
        }

        public Builder quantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder date(LocalDateTime date) {
            this.date = date;
            return this;
        }

        public TacoOrder build() {
            return new TacoOrder(tacos, quantity, date);
        }
    }

    // Getters
    public String getTacos() {
        return tacos;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDateTime getDate() {
        return date;
    }

}
