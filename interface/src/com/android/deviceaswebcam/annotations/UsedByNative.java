/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.deviceaswebcam.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Annotation used for marking methods and fields that are called from native code. Useful for
 * keeping components that would otherwise be removed by Proguard. Use the value parameter to
 * mention a file that calls this method.
 *
 * <p>Note that adding this annotation to a method is not enough to guarantee that it is kept -
 * either its class must be referenced elsewhere in the program, or the class must be annotated with
 * this as well.
 *
 * <p>Usage example:
 *
 * <pre>{@code
 * @UsedByNative("SdkFrameProvider.cpp")
 * public static void foo() {
 * ...
 * }
 * }</pre>
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE, ElementType.CONSTRUCTOR})
public @interface UsedByNative {
    String value();
}
