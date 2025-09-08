package com.service.financeService.bill.infrastructure.outputadapter.persistence.entity;

import com.service.financeService.bill.domain.model.PaymentMethodEnum;

import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "bill")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDBEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "reservation_id")
    private UUID reservationId;

    @Column(name = "order_id")
    private UUID orderId;

    @Column(nullable = false)
    private BigDecimal amount;
    @Column(name = "payment_date", insertable = false, updatable = false)
    private LocalDateTime paymentDate;

    // Use the new @JdbcTypeCode annotation with SqlTypes.ENUM
    @Enumerated(EnumType.STRING)
    @Column(name = "payment_method", columnDefinition = "payment_method_enum")
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    private PaymentMethodEnum paymentMethod;
}
