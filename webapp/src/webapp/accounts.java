/*
**
** Copyright © 2018, Oracle and/or its affiliates. All rights reserved.
** Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.
*/

package webapp;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;

import javax.ws.rs.client.Client;

import org.json.JSONArray;
import org.json.JSONObject;

@ManagedBean(name = "accounts", eager = true)
@RequestScoped
public class accounts {
    private String response = null;
    private String partyId = "";
    private String partyNumber = "";
    private String organizationName = "";
    private String ownerEmailAddress = "";

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {
        if (response == null)
            callRest();
        return response;
    }

    public void setPartyId(String partyId) {
        this.partyId = partyId;
    }

    public String getPartyId() {
        if (response == null)
            callRest();
        return partyId;
    }

    public void setPartyNumber(String partyNumber) {
        this.partyNumber = partyNumber;
    }

    public String getPartyNumber() {
        if (response == null)
            callRest();
        return partyNumber;
    }

    public void setOrganizationName(String OrganizationName) {
        this.organizationName = OrganizationName;
    }

    public String getOrganizationName() {
        if (response == null)
            callRest();
        return organizationName;
    }

    public void setOwnerEmailAddress(String OwnerEmailAddress) {
        this.ownerEmailAddress = OwnerEmailAddress;
    }

    public String getOwnerEmailAddress() {
        if (response == null)
            callRest();
        return ownerEmailAddress;
    }

    private void callRest() {
        Client client = rest.createClient();
        rest.Accounts accounts = rest.accounts(client);
        Map<String, String> params =FacesContext.getCurrentInstance().
                           getExternalContext().getRequestParameterMap();
        String id = params.get("id");
        response = accounts.getAccountDetails(id);

        try {
            JSONObject jsonObj = new JSONObject(response);
            JSONArray items = jsonObj.getJSONArray("items");
            if (items.length() > 0) {
                if (items.getJSONObject(0).get("PartyId") != JSONObject.NULL)
                    partyId = String.valueOf(items.getJSONObject(0).getLong("PartyId"));
                if (items.getJSONObject(0).get("PartyNumber") != JSONObject.NULL)
                    partyNumber = items.getJSONObject(0).getString("PartyNumber");
                if (items.getJSONObject(0).get("OrganizationName") != JSONObject.NULL)
                    organizationName = items.getJSONObject(0).getString("OrganizationName");
                if (items.getJSONObject(0).get("OwnerEmailAddress") != JSONObject.NULL)
                    ownerEmailAddress = items.getJSONObject(0).getString("OwnerEmailAddress");
            }
        }
        catch (Exception e){
            // continue 
        }
    }
}
