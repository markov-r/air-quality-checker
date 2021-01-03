package com.air.quality.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ambee_aq_batch")
public class AmbeeAqBatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = {CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = "batch_id")
    List<AmbeeAqData> batchList;

    public AmbeeAqBatch() {
    }

    public AmbeeAqBatch(List<AmbeeAqData> batchList) {
        this.batchList = batchList;
    }
}
