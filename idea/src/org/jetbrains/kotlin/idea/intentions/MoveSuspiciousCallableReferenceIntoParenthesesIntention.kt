/*
 * Copyright 2010-2017 JetBrains s.r.o.
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

package org.jetbrains.kotlin.idea.intentions

import org.jetbrains.kotlin.idea.caches.resolve.analyze
import org.jetbrains.kotlin.idea.inspections.IntentionBasedInspection
import org.jetbrains.kotlin.lexer.KtTokens
import org.jetbrains.kotlin.psi.KtCallableReferenceExpression
import org.jetbrains.kotlin.psi.KtLambdaExpression
import org.jetbrains.kotlin.resolve.calls.callUtil.getResolvedCall

class MoveSuspiciousCallableReferenceIntoParenthesesInspection :
        IntentionBasedInspection<KtLambdaExpression>(MoveSuspiciousCallableReferenceIntoParenthesesIntention::class)

class MoveSuspiciousCallableReferenceIntoParenthesesIntention : ConvertLambdaToReferenceIntention(
        "Move suspicious callable reference into parentheses '()'"
) {
    override fun buildReferenceText(element: KtLambdaExpression): String? {
        val callableReferenceExpression =
                element.bodyExpression?.statements?.singleOrNull() as? KtCallableReferenceExpression ?: return null
        val callableReference = callableReferenceExpression.callableReference
        val resolvedCall = callableReference.getResolvedCall(callableReference.analyze())
        val receiverValue = resolvedCall?.let { it.extensionReceiver ?: it.dispatchReceiver }
        return (receiverValue?.let { "${it.type}" } ?: "") + "${KtTokens.COLONCOLON.value}${callableReference.text}"
    }

    override fun isApplicableTo(element: KtLambdaExpression) =
            element.bodyExpression?.statements?.singleOrNull() is KtCallableReferenceExpression
}