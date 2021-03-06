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

import org.terasology.kallisti.base.component.ComponentInterface;
import org.terasology.kallisti.base.util.Dimension;
import org.terasology.kallisti.base.util.PixelDimension;

import java.io.IOException;
import java.io.InputStream;

/**
 * TODO: Is this temporary?
 */
@ComponentInterface
public interface FrameBuffer {
    interface Image {
        PixelDimension size();
        int[] data();
    }

    interface Renderer extends Synchronizable.Receiver {
        void update(InputStream stream) throws IOException;
        void render(FrameBuffer buffer);
    }

    void bind(Synchronizable source, Renderer renderer);
    Dimension aspectRatio();
    void blit(Image image);
}
