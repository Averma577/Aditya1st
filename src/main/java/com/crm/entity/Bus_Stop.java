package com.crm.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "bus_stop")
public class Bus_Stop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bus_id")
    private Bus_Stop busid;

    @ManyToOne
    @JoinColumn(name = "stop_id")
    private Bus_Stop stop;

    @Column(name = "order_number", nullable = false, unique = true)
    private Integer orderNumber;

    @Column(name = "departure_time", nullable = false)
    private LocalTime departureTime;

}