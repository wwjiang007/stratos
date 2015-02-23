/*
 * Licensed to the Apache Software Foundation (ASF) under one 
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY 
 * KIND, either express or implied.  See the License for the 
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.stratos.cloud.controller.domain;

import org.apache.stratos.common.Properties;
import org.apache.stratos.common.Property;
import org.apache.stratos.common.domain.NameValuePair;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Holds information about a Member.
 *
 */
public class MemberContext implements Serializable {

    private static final long serialVersionUID = -388327475844701869L;

    private final String applicationId;
    // Cartridge type this member belongs to
    private final String cartridgeType;
    // Cluster id of this member
    private final String clusterId;
    // Member id generated by cloud controller
    private final String memberId;
    // Instance id generated by the IaaS
    private String instanceId;
    // Instance id of the application hierarchy member belongs to
    private String clusterInstanceId;

    // Partition this member is in
    private Partition partition;
    // Default private ip address
    private String defaultPrivateIP;
    // Private ips
    private String[] privateIPs;
    // Default public ip address
    private String defaultPublicIP;
    // Public ips
    private String[] publicIPs;
    // Manually allocated ips
    private String[] allocatedIPs;
    // Member initiated time
    private long initTime;
    // LB cluster id of this member
    private String lbClusterId;
    // Network partition id
    private String networkPartitionId;
    // Member expiry period on the topology
    private long obsoleteExpiryTime;
    // Member obsolete init time
    private long obsoleteInitTime;
    // Instance metadata generated by the IaaS
    private InstanceMetadata instanceMetadata;
    // Properties
    private Properties properties;
    private NameValuePair[] dynamicPayload;
    private String kubernetesPodId;
    private String kubernetesPodName;

    public MemberContext(String applicationId, String cartridgeType, String clusterId, String memberId) {

        this.applicationId = applicationId;
        this.cartridgeType = cartridgeType;
        this.clusterId = clusterId;
        this.memberId = memberId;

        this.properties = new Properties();
        this.properties.setProperties(new Property[0]);
    }

    public String getApplicationId() {
        return applicationId;
    }
    
    public String getMemberId() {
        return memberId;
    }

    public String getClusterId() {
        return clusterId;
    }

    public String getCartridgeType() {
        return cartridgeType;
    }

    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    public String getDefaultPublicIP() {
        return defaultPublicIP;
    }

    public void setDefaultPublicIP(String defaultPublicIP) {
        this.defaultPublicIP = defaultPublicIP;
    }
    
    public String[] getPublicIPs() {
        return publicIPs;
    }

    public void setPublicIPs(String[] publicIPs) {
        this.publicIPs = publicIPs;
    }

    public String getDefaultPrivateIP() {
        return defaultPrivateIP;
    }

    public void setDefaultPrivateIP(String defaultPrivateIP) {
        this.defaultPrivateIP = defaultPrivateIP;
    }
    
    public String[] getPrivateIPs() {
        return privateIPs;
    }

    public void setPrivateIPs(String[] privateIPs) {
        this.privateIPs = privateIPs;
    }

    public String[] getAllocatedIPs() {
        return allocatedIPs;
    }

    public void setAllocatedIPs(String[] allocatedIPs) {
        this.allocatedIPs = allocatedIPs;
    }

    public long getInitTime() {
        return initTime;
    }

    public void setInitTime(long initTime) {
        this.initTime = initTime;
    }

    public String getLbClusterId() {
        return lbClusterId;
    }

    public void setLbClusterId(String lbClusterId) {
        this.lbClusterId = lbClusterId;
    }

    public String getNetworkPartitionId() {
        return networkPartitionId;
    }

    public void setNetworkPartitionId(String networkPartitionId) {
        this.networkPartitionId = networkPartitionId;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((clusterId == null) ? 0 : clusterId.hashCode());
		result = prime * result
				+ ((memberId == null) ? 0 : memberId.hashCode());
		result = prime * result + ((instanceId == null) ? 0 : instanceId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

        MemberContext other = (MemberContext) obj;
		if(getApplicationId().equals(other.getApplicationId()) &&
                getCartridgeType().equals(other.getCartridgeType()) &&
                getClusterId().equals(other.getClusterId()) &&
                getMemberId().equals(other.getMemberId()) &&
                getInstanceId().equals(other.getInstanceId())) {
            return true;
        }
		return false;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

    public long getObsoleteExpiryTime() {
        return obsoleteExpiryTime;
    }

    public void setObsoleteExpiryTime(long obsoleteExpiryTime) {
        this.obsoleteExpiryTime = obsoleteExpiryTime;
    }

    public long getObsoleteInitTime() {
        return obsoleteInitTime;
    }

    public void setObsoleteInitTime(long obsoleteInitTime) {
        this.obsoleteInitTime = obsoleteInitTime;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public InstanceMetadata getInstanceMetadata() {
        return instanceMetadata;
    }

    public void setInstanceMetadata(InstanceMetadata instanceMetadata) {
        this.instanceMetadata = instanceMetadata;
    }

    public void setClusterInstanceId(String clusterInstanceId) {
        this.clusterInstanceId = clusterInstanceId;
    }

    public String getClusterInstanceId() {
        return clusterInstanceId;
    }

    public void setDynamicPayload(NameValuePair[] dynamicPayload) {
        this.dynamicPayload = dynamicPayload;
    }

    public NameValuePair[] getDynamicPayload() {
        return dynamicPayload;
    }

    public void setKubernetesPodId(String kubernetesPodId) {
        this.kubernetesPodId = kubernetesPodId;
    }

    public String getKubernetesPodId() {
        return kubernetesPodId;
    }

    public void setKubernetesPodName(String kubernetesPodName) {
        this.kubernetesPodName = kubernetesPodName;
    }

    public String getKubernetesPodName() {
        return kubernetesPodName;
    }

    @Override
    public String toString() {
        return "MemberContext ["
                + "applicationId=" + applicationId
                + ", cartridgeType=" + cartridgeType
                + ", clusterId=" + clusterId
                + ", memberId=" + memberId
                + ", instanceId=" + instanceId
                + ", partition=" + partition
                + ", defaultPrivateIP=" + defaultPrivateIP
                + ", defaultPublicIP=" + defaultPublicIP
                + ", allocatedIPs=" + Arrays.toString(allocatedIPs)
                + ", publicIPs=" + Arrays.toString(publicIPs)
                + ", privateIPs=" + Arrays.toString(privateIPs)
                + ", initTime=" + initTime
                + ", lbClusterId=" + lbClusterId
                + ", networkPartitionId=" + networkPartitionId
                + ", kubernetesPodId=" + kubernetesPodId
                + ", kubernetesPodName=" + kubernetesPodName
                + ", instanceMetadata=" + instanceMetadata
                + ", properties=" + properties + "]";
    }
}
