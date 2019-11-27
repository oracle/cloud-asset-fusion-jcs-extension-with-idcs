/*
**
** Copyright © 2018, Oracle and/or its affiliates. All rights reserved.
** Licensed under the Universal Permissive License v 1.0 as shown at https://oss.oracle.com/licenses/upl.
*/

package webapp;

import javax.annotation.Generated;

import javax.ws.rs.client.Client;

import org.json.JSONArray;
import org.json.JSONObject;

@Generated({ "Oracle JDeveloper", "run|74b48ca2-bd05-4c89-8045-1df0100579bb" })
public class restClient {
    public static void main(String[] args) {
        Client client = rest.createClient();
        rest.Accounts accounts = rest.accounts(client);
        String response = accounts.getAccountDetails("MaxFroeschl01");
        System.out.println("Response: " + response);
        JSONObject jsonObj = new JSONObject(response);
        JSONArray items = jsonObj.getJSONArray("items");
           for (int i = 0; i < items.length(); i++) {
               if (items.getJSONObject(i).get("PartyId") != JSONObject.NULL)
                   System.out.println("Party Id: " + String.valueOf(items.getJSONObject(i).getLong("PartyId")));
               if (items.getJSONObject(i).get("PartyNumber") != JSONObject.NULL)
                   System.out.println("Party Number: " + items.getJSONObject(i).getString("PartyNumber"));
               if (items.getJSONObject(i).get("OrganizationName") != JSONObject.NULL)
                   System.out.println("Organization Name: " + items.getJSONObject(i).getString("OrganizationName"));
               if (items.getJSONObject(i).get("OwnerEmailAddress") != JSONObject.NULL)
                   System.out.println("Owner Email Address: " + items.getJSONObject(i).getString("OwnerEmailAddress"));
           }
    }
}
