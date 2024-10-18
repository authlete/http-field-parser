# HTTP Field Parser for Java

This is a collection of parsers for HTTP field values, written using
[ANTLR4][ANTLR4].

Currently, this library contains parsers for the following:

- Token ([RFC 9110: HTTP Semantics, Section 5.6.2. Tokens][RFC_9110_5_6_2])
- Quoted String ([RFC 9110: HTTP Semantics, Section 5.6.4. Quoted Strings][RFC_9110_5_6_4])
- Forwarded HTTP Header Field ([RFC 7239: Forwarded HTTP Extension, Section 4. Forwarded HTTP Header Field][RFC_7239_4])

## License

Apache License, Version 2.0

## Maven

```xml
<dependency>
    <groupId>com.authlete.http</groupId>
    <artifactId>http-field-parser</artifactId>
    <version>${http-field-parser.version}</version>
</dependency>
```

Check the [CHANGES.md](CHANGES.md) file to know the latest version.

## Source Code

<code>https://github.com/authlete/http-field-parser</code>

## JavaDoc

<code>https://authlete.github.io/http-field-parser</code>

## Standard Specifications

The following is a non-exhaustive list of standard specifications related to
this library.

### IETF RFC

- [RFC 5234][RFC_5234] Augmented BNF for Syntax Specifications: ABNF
- [RFC 7239][RFC_7239] Forwarded HTTP Extension
- [RFC 9110][RFC_9110] HTTP Semantics

## Note

If the `src/main/antlr4/com/authlete/http/antlr/*.g4` files are modified,
the following command must be executed to regenerate the corresponding
Java source files.

```
mvn antlr4:antlr4
```

## Contact

Authlete Contact Form: https://www.authlete.com/contact/

<!-- ==================== LINKS ==================== -->

[RFC_5234]: https://www.rfc-editor.org/rfc/rfc5234.html
[RFC_7239]: https://www.rfc-editor.org/rfc/rfc7239.html
[RFC_7239_4]: https://www.rfc-editor.org/rfc/rfc7239.html#section-4
[RFC_9110]: https://www.rfc-editor.org/rfc/rfc9110.html
[RFC_9110_5_6_2]: https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.2
[RFC_9110_5_6_4]: https://www.rfc-editor.org/rfc/rfc9110.html#section-5.6.4

[ANTLR4]: https://www.antlr.org/
