  case class ExtendedDiffHeader(headerLines: Seq[HeaderLine], index: Option[Index])
  def gitDiff: Parser[GitDiff] = gitDiffHeader ~ extendedDiffHeader ~ hunks ^^ {
    ) ~ opt(index) ^^
  def lineChange: Parser[LineChange] = ctxLine | addedLine | removedLine | noNewLineAtEOF | newLine
  def noNewLineAtEOF: Parser[CtxLine] = "\\ No newline at end of file" <~ opt(nl) ^^ { l => CtxLine(l) }

  def newLine: Parser[CtxLine] = nl ^^ { l => CtxLine("") }
