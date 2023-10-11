package it.euris.academy.teslabattery_ac.entity;

import it.euris.academy.teslabattery_ac.enums.RobotRoleType;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer_order")
public class Robot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "robot_role_type")
    @Enumerated(EnumType.STRING)
    private RobotRoleType robotRoleType;

    @Column(name = "location")
    private Integer location;

    @Column(name = "characteristics")
    private String characteristics;


}
