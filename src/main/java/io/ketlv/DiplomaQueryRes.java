package io.ketlv;

import com.owlike.genson.annotation.JsonProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.hyperledger.fabric.contract.annotation.DataType;
import org.hyperledger.fabric.contract.annotation.Property;

/**
 * DiplomaQueryResult structure used for handling result of query
 */
@DataType()
public class DiplomaQueryRes {
    @Property()
    private final String key;
    @Property()
    private final Diploma record;

    public DiplomaQueryRes(@JsonProperty("Key") String key, @JsonProperty("Record") Diploma record) {
        this.key = key;
        this.record = record;
    }

    public String getKey() {
        return key;
    }

    public Diploma getRecord() {
        return record;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        DiplomaQueryRes that = (DiplomaQueryRes) o;

        return new EqualsBuilder().append(key, that.key).append(record, that.record).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(key).append(record).toHashCode();
    }
}
