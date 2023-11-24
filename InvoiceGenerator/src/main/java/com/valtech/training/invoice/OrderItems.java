    package com.valtech.training.invoice;

    import javax.persistence.*;

    @Entity
    @Table(name = "order_items")
    public class OrderItems {

        @EmbeddedId
        private OrderItemId id;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @MapsId("orderId")
        @JoinColumn(name = "order_id",insertable = false,updatable = false)
        private Order order;

        @ManyToOne(cascade = CascadeType.PERSIST)
        @MapsId("productId")
        @JoinColumn(name = "product_id",insertable = false,updatable = false)
        private Product product;

        // Add any other necessary fields

        public OrderItems() {
            // Default constructor required by Hibernate
        }

        public OrderItems(Order order, Product product) {
            this.order = order;
            this.product = product;
            this.id = new OrderItemId(order.getOrderId(), product.getProductId());
        }

		public OrderItemId getId() {
			return id;
		}

		public void setId(OrderItemId id) {
			this.id = id;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

        // Add getters and setters as needed
        
    }
    