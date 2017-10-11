package js.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class DATAGROUP {
    @Id
    private int id;

    @Column
    private String bezeichnung;

    @ManyToMany
    @JoinTable(
            name = "DATAGROUP_X_DR",
            joinColumns = @JoinColumn(name = "DATAGROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "DR_ID", referencedColumnName = "ID"))
    Set<DR> drs = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "DATAGROUP_X_VK",
            joinColumns = @JoinColumn(name = "DATAGROUP_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "VK_ID", referencedColumnName = "ID"))
    Set<VK> vks = new HashSet<>();

    public DATAGROUP() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }
}
