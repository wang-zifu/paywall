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
package org.lightningj.paywall.lightninghandler;

/**
 * Enumeration on supported Lightning events that listeners might get alerted of.
 *
 * Created by Philip Vendil on 2018-11-24.
 */
public enum LightningEventType {
    /**
     * Event indicating an invoice was added by LightningHandler.
     */
    ADDED,
    /**
     * Event indicating an invoice was settled by LightningHandler.
     */
    SETTLEMENT
}
