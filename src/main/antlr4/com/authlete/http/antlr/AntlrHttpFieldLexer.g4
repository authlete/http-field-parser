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
lexer grammar AntlrHttpFieldLexer;


COMMA     : ',';
SEMICOLON : ';';
EQUALS    : '=';


//-------------------------------------------------------------------
// Core Rules
//
//   RFC 5234: Augmented BNF for Syntax Specifications: ABNF
//   B.1. Core Rules
//
//       ALPHA  = %x41-5A / %x61-7A  ; A-Z / a-z
//       DIGIT  = %x30-39            ; 0-9
//       DQUOTE = %x22               ; double quote
//       HTAB   = %x09               ; horizontal tab
//       SP     = %x20               ; space
//       VCHAR  = %x21-7E            ; visible (printing) characters
//
//-------------------------------------------------------------------


//-------------------------------------------------------------------
// Field Values
//
//   RFC 9110: HTTP Semantics
//   5.5. Field Values
//
//       obs-text = %x80-FF
//
//-------------------------------------------------------------------


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
TokenCharacterSequence
    : TokenCharacter+
    ;

fragment
TokenCharacter
    : [!#$%&'*+.^_`|~0-9A-Za-z-]
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
WhiteSpaceCharacterSequence
    : WhiteSpaceCharacter+
    ;

fragment
WhiteSpaceCharacter
    : [ \t]
    ;


//-------------------------------------------------------------------
// Quoted Strings
//
//   RFC 9110: HTTP Semantics
//   5.6.4. Quoted Strings
//
//       quoted-string = DQUOTE *( qdtext / quoted-pair ) DQUOTE
//       qdtext        = HTAB / SP / %x21 / %x23-5B / %x5D-7E / obs-text
//       quoted-pair   = "\" ( HTAB / SP / VCHAR / obs-text )
//
//-------------------------------------------------------------------
fragment
QuotedStringCharacterSequence
    : QuotedStringCharacter+
    ;

fragment
QuotedStringCharacter
    : [\t \u0021\u0023-\u005B\u005D-\u007E\u0080-\u00FF]
    | '\\' [\t \u0021-\u007E\u0080-\u00FF]
    ;

// Mode switcher for Quoted String
QuotedStringOpen
    : '"' -> pushMode(INSIDE_QUOTED_STRING)
    ;

// Mode for Quoted String
mode INSIDE_QUOTED_STRING;

QuotedStringClose
    : '"' -> popMode
    ;

QuotedStringContent
    : QuotedStringCharacterSequence
    ;
