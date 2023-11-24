    package com.valtech.training.invoice;

    import java.io.Serializable;
    import java.util.Objects;

    import javax.persistence.Column;
    import javax.persistence.Embeddable;
import javax.persistence.Entity;
    
  
    @Embeddable
    public class OrderItemId implements Serializable {

        @Column(name = "order_id")
        private int orderId;

        @Column(name = "product_id")
        private int productId;

        // Default constructor required by Hibernate
        public OrderItemId() {}

        public OrderItemId(int orderId, int productId) {
            this.orderId = orderId;
            this.productId = productId;
        }

        // Override equals and hashCode
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            OrderItemId that = (OrderItemId) obj;

            return orderId == that.orderId && productId == that.productId;
        }

        @Override
        public int hashCode() {
            return Objects.hash(orderId, productId);
        }
    }
    