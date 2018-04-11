/*
 * Copyright 2010-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license
 * that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.types;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.descriptors.ClassDescriptor;
import org.jetbrains.kotlin.descriptors.TypeParameterDescriptor;

import java.util.Collection;
import java.util.List;

/**
 * TypeConstructor with *trusted* list of supertypes
 *
 * The only difference from ClassTypeConstructorImpl is that UnsafeClassTypeConstructor won't go through
 * supertypes loop disconnection mechanism in AbstractTypeConstructor -- instead it will return 'supertypes'
 * straight away.
 */
public class UnsafeClassTypeConstructor extends ClassTypeConstructorImpl implements TypeConstructor {
    public UnsafeClassTypeConstructor(
            @NotNull ClassDescriptor classDescriptor,
            @NotNull List<? extends TypeParameterDescriptor> parameters,
            @NotNull Collection<KotlinType> supertypes
    ) {
        super(classDescriptor, parameters, supertypes);
    }

    @NotNull
    @Override
    public List<KotlinType> getSupertypes() {
        return supertypes;
    }

    @NotNull
    @Override
    protected Collection<KotlinType> computeSupertypes() {
        throw new IllegalStateException("Don't call 'computeSupertypes' on UnsafeClassTypeConstructor: " + this);
    }
}
