package org.springframework.samples.petclinic.recoveryroom;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.pet.Visit;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "recovery_room")
public class RecoveryRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NotNull
    @Size (min = 3, max = 50)
    String name;

    @PositiveOrZero
    @NotNull
    double size;
    
    @NotNull
    boolean secure;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recoveryRoom", fetch = FetchType.EAGER)
	private Set<Visit> visits;

    @ManyToOne
    @JoinColumn(name = "t2_id")
    RecoveryRoomType roomType;
}
