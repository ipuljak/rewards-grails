<div class="container">
    <div class="row">
        <div class="col-sm-12">
            <g:img file="banner.png" />

        </div>
    </div>

    <div class="row">
        <div class="col-sm-5 col-sm-offset-1">
            <h3>Welcome back Mike.</h3>
            <p>You have 3 points.</p>
        </div>
        <div class="col-sm-6">
            <g:textField name="phone" class="form-control" placeholder="Enter your cell number to check in" />
            <div class="row">
                <h3></h3>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="1" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="2" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="3" onclick="padkey(this.value)" />
                </div>
            </div>
            <div class="row">
                <h3></h3>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="4" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="5" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="6" onclick="padkey(this.value)" />
                </div>
            </div>
            <div class="row">
                <h3></h3>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="7" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="8" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="9" onclick="padkey(this.value)" />
                </div>
            </div>
            <div class="row">
                <h3></h3>
            </div>
            <div class="row">
                <div class="col-sm-4">
                    <input class="btn btn-danger btn-lg btn-block" type="button" name="pad" value="Del" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-primary btn-lg btn-block" type="button" name="pad" value="0" onclick="padkey(this.value)" />
                </div>
                <div class="col-sm-4">
                    <input class="btn btn-success btn-lg btn-block" type="button" name="pad" value="Go" onclick="padkey(this.value)" />
                </div>
            </div>
        </div>
    </div> <!-- End Nested Rows -->
</div> <!-- End Container -->

<!-- pad button script -->
<script> function padkey(num) {
	var txt=document.getElementById("phone").value;
	txt=txt + num;
	document.getElementById("phone").value=txt;
	}
</script>