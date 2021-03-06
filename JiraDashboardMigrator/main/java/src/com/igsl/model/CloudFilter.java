package com.igsl.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CloudFilter {
	private String id;
	private String name;
	private String description;
	private String jql;
	private List<CloudPermission> sharePermissions;
	private List<CloudPermission> editPermissions;
	
	public static CloudFilter create(DataCenterFilter filter) {
		CloudFilter result = null;
		if (filter != null) {
			result = new CloudFilter();
			result.name = filter.getName();
			result.description = filter.getDescription();
			result.jql = filter.getJql();
			// TODO Add JQL parser and converter
			result.sharePermissions = new ArrayList<CloudPermission>();
			result.editPermissions = new ArrayList<CloudPermission>();
			for (DataCenterPermission permission : filter.getSharePermissions()) {
				if (permission.isEdit()) {
					CloudPermission cp = CloudPermission.create(permission);
					result.editPermissions.add(cp);
				}
				if (permission.isView()) {
					CloudPermission cp = CloudPermission.create(permission);
					result.sharePermissions.add(cp);
				}
			}
		}
		return result;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getJql() {
		return jql;
	}
	public void setJql(String jql) {
		this.jql = jql;
	}
	public List<CloudPermission> getSharePermissions() {
		return sharePermissions;
	}
	public void setSharePermissions(List<CloudPermission> sharePermissions) {
		this.sharePermissions = sharePermissions;
	}
	public List<CloudPermission> getEditPermissions() {
		return editPermissions;
	}
	public void setEditPermissions(List<CloudPermission> editPermissions) {
		this.editPermissions = editPermissions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
