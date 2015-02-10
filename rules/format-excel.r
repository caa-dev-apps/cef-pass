Sys.setenv(JAVA_HOME="")
#install.packages("XLConnect")
library ( XLConnect )

wb <- loadWorkbook("./../CAA_RULES_COMBO.xlsx")
ws <-readWorksheet (wb, sheet="Rules2", startRow=1,
                    header = TRUE )
View(ws)
head(ws)

for(i in 1:nrow(ws)) {
  row <- ws[i,]
  
  ls <- c(
    sprintf(""),
    sprintf(""),
    sprintf("Rule:              %.2f", row$Rule.Number),
    sprintf("Scope:             %s", row$Scope),
    sprintf("Keyword:           %s", row$Keyword),
    sprintf("Data.type:         %s", row$Data.type),
    sprintf("Cardinality:       %s", row$Cardinality),
    sprintf("Description:       %s", row$Description),
    sprintf("Error.Type:        %s", row$Error.Type),
    sprintf("Error.Message:     %s", row$Error.Message),
    sprintf("Caveats:           %s", row$Caveats)    
    
  )
  
  writeLines(ls)
}

