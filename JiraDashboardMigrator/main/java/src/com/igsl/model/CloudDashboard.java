package com.igsl.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CloudDashboard {
	private String id;
	private String name;
	private String description;
	private List<CloudPermission> sharePermissions;
	private List<CloudPermission> editPermissions;
	public static CloudDashboard create(DataCenterPortalPage data) {
		CloudDashboard result = null;
		if (data != null) {
			result = new CloudDashboard();
			result.name = data.getPageName();
			result.description = data.getDescription();
			result.sharePermissions = new ArrayList<>();
			result.editPermissions = new ArrayList<>();
			for (DataCenterPortalPermission permission : data.getPermissions()) {
				if ((permission.getRights() & 1) == 1) {
					// View
					result.sharePermissions.add(CloudPermission.create(permission));
				} else if ((permission.getRights() & 2) == 2) {
					// Edit
					result.editPermissions.add(CloudPermission.create(permission));
				}
			}
		}
		return result;
	}
	// Generated
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
