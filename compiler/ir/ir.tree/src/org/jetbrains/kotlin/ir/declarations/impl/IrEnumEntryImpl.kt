/*
 * Copyright 2010-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.kotlin.ir.declarations.impl

import org.jetbrains.kotlin.descriptors.ClassDescriptor
import org.jetbrains.kotlin.ir.declarations.IrClass
import org.jetbrains.kotlin.ir.declarations.IrDeclarationOrigin
import org.jetbrains.kotlin.ir.declarations.IrEnumEntry
import org.jetbrains.kotlin.ir.expressions.IrExpression
import org.jetbrains.kotlin.ir.visitors.IrElementTransformer
import org.jetbrains.kotlin.ir.visitors.IrElementVisitor

class IrEnumEntryImpl(
        startOffset: Int,
        endOffset: Int,
        origin: IrDeclarationOrigin,
        override val descriptor: ClassDescriptor
) : IrDeclarationBase(startOffset, endOffset, origin), IrEnumEntry {
    constructor(
            startOffset: Int, endOffset: Int, origin: IrDeclarationOrigin, descriptor: ClassDescriptor,
            correspondingClass: IrClass?, initializerExpression: IrExpression
    ) : this(startOffset, endOffset, origin, descriptor) {
        this.correspondingClass = correspondingClass
        this.initializerExpression = initializerExpression
    }

    override var correspondingClass: IrClass? = null
    override lateinit var initializerExpression: IrExpression

    override fun <R, D> accept(visitor: IrElementVisitor<R, D>, data: D): R {
        return visitor.visitEnumEntry(this, data)
    }

    override fun <D> acceptChildren(visitor: IrElementVisitor<Unit, D>, data: D) {
        initializerExpression.accept(visitor, data)
        correspondingClass?.accept(visitor, data)
    }

    override fun <D> transformChildren(transformer: IrElementTransformer<D>, data: D) {
        initializerExpression = initializerExpression.transform(transformer, data)
        correspondingClass = correspondingClass?.transform(transformer, data) as? IrClass
    }
}