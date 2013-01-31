package com.thoughtworks.bitemoi.javayelp.wiretypes;

import java.util.Set;

public class SearchWireType {
    private final Set<BusinessWireType> businesses;

    public SearchWireType() { this(null); }

    public SearchWireType(Set<BusinessWireType> businesses) {
        this.businesses = businesses;
    }

    public Set<BusinessWireType> getBusinesses() {
        return businesses;
    }
}
