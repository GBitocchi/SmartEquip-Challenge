# Market + Auction Value CHALLENGE:
Included in this folder is the mocked API response for two sets of equipment. Spend some time visualizing and understanding the data structure.
For each year, there are two ratios, auctionRatio and MarketRatio. The cost is per set of equipment (ID).
If we want to calculate the 'value' of a set and year, we multiply the ratio for that year with the cost in saleDetails for that set.
MarketValue = {cost} * {marketRatio}
AuctionValue = {cost} * {auctionRatio}

## Task #1 - Write a function that takes the model id and year, and returns an object containing the calculated values (Market and Auction)
  
## Task #2 - Adjust the function to ensure it handles incorrect input (EX: ID doesn't exist) graciously, you can do so however you prefer.
  
## Task #3 - Add code to test your function, pass it the parameters below and log the result to the console. Do not request user input. Year 2007 ID 67352, Year 2011 ID 87964
