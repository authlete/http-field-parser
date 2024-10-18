/*
 * Copyright (C) 2024 Authlete, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
parser grammar AntlrHttpFieldParser;


options {
    tokenVocab=AntlrHttpFieldLexer;
}


//-------------------------------------------------------------------
// Token
//
//   RFC 9110: HTTP Semantics
//   5.6.2. Tokens
//
//       token = 1*tchar
//
//       tchar = "!" / "#" / "$" / "%" / "&" / "'" / "*"
//             / "+" / "-" / "." / "^" / "_" / "`" / "|" / "~"
//             / DIGIT / ALPHA
//
//-------------------------------------------------------------------
token
    : TokenCharacterSequence
    ;

tokenWithEOF
    : token EOF
    ;


//-------------------------------------------------------------------
// Whitespace
//
//   RFC 9110: HTTP Semantics
//   5.6.3. Whitespace
//
//       OWS = *( SP / HTAB )
//           ; optional whitespace
//       RWS = 1*( SP / HTAB )
//           ; required whitespace
//       BWS = OWS
//           ; "bad" whitespace
//
//-------------------------------------------------------------------
whiteSpace
    : WhiteSpaceCharacterSequence
    ;


//-------------------------------------------------------------------
// Quoted String
//
//   RFC 9110: HTTP Semantics
//   5.6.4. Quoted Strings
//
//     quoted-string = DQUOTE *( qdtext / quoted-pair ) DQUOTE
//     qdtext        = HTAB / SP / %x21 / %x23-5B / %x5D-7E / obs-text
//     quoted-pair   = "\" ( HTAB / SP / VCHAR / obs-text )
//
//-------------------------------------------------------------------
quotedString
    : QuotedStringOpen quotedStringContent* QuotedStringClose
    ;

quotedStringWithEOF
    : quotedString EOF
    ;

quotedStringContent
    : QuotedStringContent
    ;


//-------------------------------------------------------------------
// RFC 7239: Forwarded HTTP Extension
//
//   RFC 7239: Forwarded HTTP Extension
//   4. Forwarded HTTP Header Field
//
//     Forwarded   = 1#forwarded-element
//
//     forwarded-element =
//         [ forwarded-pair ] *( ";" [ forwarded-pair ] )
//
//     forwarded-pair = token "=" value
//     value          = token / quoted-string
//
//     token = <Defined in [RFC7230], Section 3.2.6>
//     quoted-string = <Defined in [RFC7230], Section 3.2.6>
//
//-------------------------------------------------------------------
forwardedFieldValue
    : forwardedElement (whiteSpace* COMMA whiteSpace* forwardedElement)*
    ;

forwardedFieldValueWithEOF
    : forwardedFieldValue EOF
    ;

forwardedElement
    : forwardedPair (whiteSpace* SEMICOLON whiteSpace* forwardedPair)*
    ;

forwardedElementWithEOF
    : forwardedElement EOF
    ;

forwardedPair
    : forwardedPairName whiteSpace* EQUALS whiteSpace* forwardedPairValue
    ;

forwardedPairWithEOF
    : forwardedPair EOF
    ;

forwardedPairName
    : token
    ;

forwardedPairNameWithEOF
    : forwardedPairName EOF
    ;

forwardedPairValue
    : token
    | quotedString
    ;

forwardedPairValueWithEOF
    : forwardedPairValue EOF
    ;
