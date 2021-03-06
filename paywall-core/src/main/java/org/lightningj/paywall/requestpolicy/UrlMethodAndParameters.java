/*
 *************************************************************************
 *                                                                       *
 *  LightningJ                                                           *
 *                                                                       *
 *  This software is free software; you can redistribute it and/or       *
 *  modify it under the terms of the GNU Lesser General Public License   *
 *  (LGPL-3.0-or-later)                                                  *
 *  License as published by the Free Software Foundation; either         *
 *  version 3 of the License, or any later version.                      *
 *                                                                       *
 *  See terms of license at gnu.org.                                     *
 *                                                                       *
 *************************************************************************/
package org.lightningj.paywall.requestpolicy;

import org.lightningj.paywall.InternalErrorException;
import org.lightningj.paywall.web.CachableHttpServletRequest;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

/**
 * Policy that checks the URL and Method and all parameters of a request.
 *
 * Created by Philip Vendil on 2018-10-27.
 */
public class UrlMethodAndParameters extends UrlAndMethod {

    /**
     * Method to aggregates the HTTP method and URL (without parameters) from
     * the request.
     *
     * @param request the cachable http servlet request to aggregate request data for.
     * @param daos    data output stream to write data to.
     * @throws IllegalArgumentException if supplied request contained invalid data.
     * @throws IOException              if i/o related problems occurred reading the request data.
     * @throws InternalErrorException   if internal errors occurred reading the request data.
     */
    @Override
    protected void aggregateSignificantData(CachableHttpServletRequest request, DataOutputStream daos) throws IllegalArgumentException, IOException, InternalErrorException {
        super.aggregateSignificantData(request,daos);
        Map<String,String[]> params = request.getParameterMap();
        for(String name : params.keySet()){
            daos.writeUTF(name);
            String[] values = params.get(name);
            if(values != null){
                for(String value : values){
                    daos.writeUTF(value);
                }
            }
        }
    }
}
