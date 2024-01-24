package uz.turgunboyevjurabek.navdrawer

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalContext
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.navdrawer.ui.theme.NavDrawerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavDrawerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.inverseOnSurface
                ) {
                    val context= LocalContext.current
                    Greeting(context)
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Greeting(locaContext: Context) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically) {
                    Image(painter = painterResource(id = R.drawable.r1),
                        contentDescription = null, modifier = Modifier.size(100.dp).clip(CircleShape),
                        contentScale = ContentScale.Crop,
                    )
                    Column {
                        Text(text = "Android", fontFamily = FontFamily.Serif)
                        Text(text = "Jetpack Compose", fontFamily = FontFamily.Serif)
                    }

                    
                }
                Divider()
                NavigationDrawerItem(
                    label = {
                        Text(text = "Drawer Item1", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold)
                            },
                    selected = false,
                    onClick = {
                        Toast.makeText(locaContext, "Nimagap 1", Toast.LENGTH_SHORT).show()
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Drawer Item2", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold)
                            },
                    selected =false,
                    onClick = {
                        Toast.makeText(locaContext, "Nimagap 2", Toast.LENGTH_SHORT).show()
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Drawer Item3", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold)
                            },
                    selected =false,
                    onClick = {
                        Toast.makeText(locaContext, "Nimagap 3", Toast.LENGTH_SHORT).show()
                    }
                )
                NavigationDrawerItem(
                    label = {
                        Text(text = "Drawer Item4", fontFamily = FontFamily.SansSerif, fontWeight = FontWeight.ExtraBold)
                            },
                    selected =false,
                    onClick = {
                        Toast.makeText(locaContext, "Nimagap 4", Toast.LENGTH_SHORT).show()
                    }
                )

            }
        },
    ) {
        Scaffold(
            floatingActionButton = {
                ExtendedFloatingActionButton(
                    text = { Text("Show drawer") },
                    icon = { Icon(Icons.Filled.Add, contentDescription = "") },
                    onClick = {
                        scope.launch {
                            drawerState.apply {
                                if (isClosed) open() else close()
                            }
                        }
                    },
                )
            }
        ) {
            // Screen content
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GreetingPreview() {
    NavDrawerTheme {
        val locaContext= LocalContext.current
        Greeting(locaContext)
    }
}