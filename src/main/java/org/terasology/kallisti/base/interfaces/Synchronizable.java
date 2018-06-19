/*
 * Copyright 2018 Adrian Siekierka, MovingBlocks
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

package org.terasology.kallisti.base.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * An interface for components which can be synchronized across the network,
 * from the server to the client.
 */
public interface Synchronizable {
    /**
     * An interface for classes capable of receiving data from a matching
     * Synchronizable.
     */
    interface Receiver {
        void update(InputStream stream) throws IOException;
    }

    enum Type {
        /**
         * Intial update for a given client.
         */
        INITIAL,
        /**
         * Any future update for a given client.
         */
        DELTA
    }

    /**
     * Check if the component has a ready synchronization packet of a given
     * type.
     * @param type The type.
     * @return Whether a synchronization packet can be made or not.
     */
    boolean hasSyncPacket(Type type);

    /**
     * Write the synchronization packet to the given output stream.
     * @param type The packet type.
     * @param stream The given output stream.
     * @throws IOException Upon packet writing issues.
     */
    void writeSyncPacket(Type type, OutputStream stream) throws IOException;
}
