<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="main"/>
    <title>What Do We Know : Ask for data</title>
  </head>
  <body>

    <br/>

    <div class="container">
      <div class="row">

        <div class="col-lg-12 well">

        <form role="form">
          <div class="form-group">
            <label for="exampleInputEmail1">Relevant Public Authority</label>
            <input type="text" class="form-control" id="authority" placeholder="Name of public authority for your request">
            <p class="help-block">Does your data request relate to a specific public authority? If so, please let us know which one - This will help us direct the request to an appropriate officer.</p>
          </div>
          <div>
            <label for="exampleInputEmail1">Relevant Place</label>
            <input type="text" class="form-control" id="place" placeholder="Name of region for your request">
            <p class="help-block">Does your data request relate to a specific region or area? If so, please let us know - This will help us put you in touch with local data wranglers who might be able to point you in the right direction.</p>
          </div>

        </form>
          <ol>
  
            <li><br/><p>
              <h3>Does your data request relate to a specific subject or kind of information? If so, please let us know - This also helps us find people who might know where this data is, or be able to help getting it published.</h3>
              <input type="text" name="Subject" class="col-lg-12" placeholder="Subject keywords for your request"/>
              <ul>
              </ul>
            </p></li>
  
            <li><br/><p>
              <h3>Briefly describe the data you need. We will use this information in combination with the other information on this screen to try and match known existing data sets. If we're unable to locate anything this information will form the basis of a request to the open data groups near you who might be able to help.</h3>
              <h4>Summary</h4>
              <input type="text" name="summary" class="col-lg-12" placeholder="One line description of your request for data"/>
              <h4>Description</h4>
              <textarea name="desc" rows="5" class="col-lg-12" placeholder="A full description of your request"></textarea>
            </p></li>
          </ol>
        </div>
      </div>
    </div>

  </body>
</html>
