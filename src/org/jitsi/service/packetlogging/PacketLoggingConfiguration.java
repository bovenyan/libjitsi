/*
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jitsi.service.packetlogging;

/**
 * Stores the configuration used by Packet Logging Service.
 *
 * @author Damian Minkov
 */
public class PacketLoggingConfiguration
{
    /**
     * Configuration property for packet logging enabled/disabled.
     */
    public final static String PACKET_LOGGING_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_ENABLED";

    /**
     * Configuration property for packet logging for
     * sip protocol enabled/disabled.
     */
    public final static String PACKET_LOGGING_SIP_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_SIP_ENABLED";

    /**
     * Configuration property for packet logging for
     * jabber protocol enabled/disabled.
     */
    public final static String PACKET_LOGGING_JABBER_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_JABBER_ENABLED";

    /**
     * Configuration property for packet logging for
     * RTP enabled/disabled.
     */
    public final static String PACKET_LOGGING_RTP_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_RTP_ENABLED";

    /**
     * Configuration property for packet logging for
     * ICE4J enabled/disabled.
     */
    public final static String PACKET_LOGGING_ICE4J_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_ICE4J_ENABLED";

    /**
     * Configuration property for enabling/disabling arbitrary packet logging.
     */
    public final static String PACKET_LOGGING_ARBITRARY_ENABLED_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging." +
            "PACKET_LOGGING_ARBITRARY_ENABLED";

    /**
     * Configuration property for packet logging file count.
     */
    public final static String PACKET_LOGGING_FILE_COUNT_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_FILE_COUNT";

    /**
     * Configuration property for packet logging file size.
     */
    public final static String PACKET_LOGGING_FILE_SIZE_PROPERTY_NAME
        = "net.java.sip.communicator.packetlogging.PACKET_LOGGING_FILE_SIZE";

    /**
     * Is Packet Logging Service enabled.
     */
    private boolean globalLoggingEnabled = true;

    /**
     * Is Packet Logging Service enabled for sip protocol.
     */
    private boolean sipLoggingEnabled = true;

    /**
     * Is Packet Logging Service enabled for jabber protocol.
     */
    private boolean jabberLoggingEnabled = true;

    /**
     * Is Packet Logging Service enabled for rtp.
     */
    private boolean rtpLoggingEnabled = true;

    /**
     * Is Packet Logging Service enabled for ice4j.
     */
    private boolean ice4jLoggingEnabled = true;

    /**
     * Is Packet Logging Service enabled for arbitrary packets.
     */
    private boolean arbitraryLoggingEnabled = true;

    /**
     * The limit for the file size.
     * 0 means no limit.
     */
    private long limit = 5000000;

     /**
     * The counter for number of files.
     */
    private int logfileCount = 3;

    /**
     * Checks whether packet logging is enabled in the configuration.
     * @return <tt>true</tt> if packet logging is enabled.
     */
    public boolean isGlobalLoggingEnabled()
    {
        return this.globalLoggingEnabled;
    }

    /**
     * Checks whether packet logging is enabled in the configuration
     * for sip protocol.
     * @return <tt>true</tt> if packet logging is enabled for sip protocol.
     */
    public boolean isSipLoggingEnabled()
    {
        return this.sipLoggingEnabled;
    }

    /**
     * Checks whether packet logging is enabled in the configuration
     * for jabber protocol.
     * @return <tt>true</tt> if packet logging is enabled for jabber protocol.
     */
    public boolean isJabberLoggingEnabled()
    {
        return this.jabberLoggingEnabled;
    }

    /**
     * Checks whether packet logging is enabled in the configuration
     * for RTP.
     * @return <tt>true</tt> if packet logging is enabled for RTP.
     */
    public boolean isRTPLoggingEnabled()
    {
        return this.rtpLoggingEnabled;
    }

    /**
     * Checks whether packet logging is enabled in the configuration
     * for Ice4J.
     * @return <tt>true</tt> if packet logging is enabled for Ice4J.
     */
    public boolean isIce4JLoggingEnabled()
    {
        return this.ice4jLoggingEnabled;
    }

    /**
     * Checks whether packet logging is enabled in the configuration
     * for arbitrary packets.
     * @return <tt>true</tt> if packet logging is enabled for arbitrary
     * packets.
     */
    public boolean isArbitraryLoggingEnabled()
    {
        return this.arbitraryLoggingEnabled;
    }

    /**
     * The limit for the file size. 0 means no limit.
     * @return the file size limit.
     */
    public long getLimit()
    {
        return this.limit;
    }

    /**
     * The counter for number of files.
     * @return the number of file counts.
     */
    public int getLogfileCount()
    {
        return this.logfileCount;
    }

    /**
     * Change whether packet logging is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setGlobalLoggingEnabled(boolean enabled)
    {
        if(!enabled)
        {
            // as we are globally off, set it and to services
            this.sipLoggingEnabled = false;
            this.jabberLoggingEnabled = false;
            this.rtpLoggingEnabled = false;
            this.ice4jLoggingEnabled = false;
            this.arbitraryLoggingEnabled = false;
        }

        this.globalLoggingEnabled = enabled;
    }

    /**
     * Change whether packet logging for sip protocol is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setSipLoggingEnabled(boolean enabled)
    {
        this.sipLoggingEnabled = enabled;
    }

    /**
     * Change whether packet logging for jabber protocol is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setJabberLoggingEnabled(boolean enabled)
    {
        this.jabberLoggingEnabled = enabled;
    }

    /**
     * Change whether packet logging for RTP is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setRTPLoggingEnabled(boolean enabled)
    {
        this.rtpLoggingEnabled = true;
    }

    /**
     * Change whether packet logging for Ice4J is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setIce4JLoggingEnabled(boolean enabled)
    {
        this.ice4jLoggingEnabled = true;
    }

    /**
     * Change whether packet logging for arbitrary packets is enabled.
     * @param enabled <tt>true</tt> if we enable it.
     */
    public void setArbitraryLoggingEnabled(boolean enabled)
    {
        this.arbitraryLoggingEnabled = true;
    }

    /**
     * Changes the file size limit.
     * @param limit the new limit size.
     */
    public void setLimit(long limit)
    {
        this.limit = limit;
    }

    /**
     * Changes file count.
     * @param logfileCount the new file count.
     */
    public void setLogfileCount(int logfileCount)
    {
        this.logfileCount = logfileCount;
    }

}
