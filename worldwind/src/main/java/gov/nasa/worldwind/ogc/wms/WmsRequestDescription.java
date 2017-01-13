/*
 * Copyright (c) 2017 United States Government as represented by the Administrator of the
 * National Aeronautics and Space Administration. All Rights Reserved.
 */

package gov.nasa.worldwind.ogc.wms;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import gov.nasa.worldwind.util.xml.XmlModel;

public class WmsRequestDescription extends XmlModel {

    protected Set<String> formats = new LinkedHashSet<>();

    protected Set<WmsDcpType> dcpTypes = new LinkedHashSet<>();

    public WmsRequestDescription(String namespaceURI) {
        super(namespaceURI);
    }

    public WmsOnlineResource getOnlineResource(String requestMethod) {
        for (WmsDcpType dct : this.getDcpTypes()) {
            for (WmsDcpType.DcpInfo dcpInfo : dct.getDcpInfos()) {
                if (dcpInfo.method.equals(requestMethod)) {
                    return dcpInfo.onlineResource;
                }
            }
        }

        return null;
    }

    public Set<String> getFormats() {
        return Collections.unmodifiableSet(this.formats);
    }

    public Set<WmsDcpType> getDcpTypes() {
        return Collections.unmodifiableSet(this.dcpTypes);
    }

    @Override
    public void setField(String keyName, Object value) {
        if (keyName.equals("Format")) {
            this.formats.add(((WmsFormat) value).getFormat());
        } else if (keyName.equals("DCPType")) {
            this.dcpTypes.add((WmsDcpType) value);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\tFormats: ");
        for (String format : this.getFormats()) {
            sb.append("\t").append(format).append(", ");
        }

        sb.append("\n\tDCPTypes:\n");
        for (WmsDcpType dcpt : this.getDcpTypes()) {
            sb.append("\t\t").append(dcpt.toString()).append("\n");
        }

        return sb.toString();
    }
}
