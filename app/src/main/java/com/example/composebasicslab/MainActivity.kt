package com.example.composebasicslab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasicslab.components.AdaptiveGrid
import com.example.composebasicslab.components.AlternatingBackgroundList
import com.example.composebasicslab.components.BasicAsyncImage
import com.example.composebasicslab.components.ButtonDividerColumn
import com.example.composebasicslab.components.ButtonRow
import com.example.composebasicslab.components.ButtonRowExample
import com.example.composebasicslab.components.CenteredButtonWithSpacer
import com.example.composebasicslab.components.ClickableFavoriteIcon
import com.example.composebasicslab.components.ColoredCardList
import com.example.composebasicslab.components.CommentBox
import com.example.composebasicslab.components.DarkModeSwitch
import com.example.composebasicslab.components.DisabledButtonExample
import com.example.composebasicslab.components.FavoriteIconButton
import com.example.composebasicslab.components.FavoriteIconSelector
import com.example.composebasicslab.components.FloatingActionButtonExample
import com.example.composebasicslab.components.FloatingButtonBox
import com.example.composebasicslab.components.FruitListScreen
import com.example.composebasicslab.components.HorizontalIconRow
import com.example.composebasicslab.components.HorizontalImageCard
import com.example.composebasicslab.components.HorizontalTextRow
import com.example.composebasicslab.components.IconSpacerRow
import com.example.composebasicslab.components.IconTextCard
import com.example.composebasicslab.components.IconWithTextRow
import com.example.composebasicslab.components.ImageCardList
import com.example.composebasicslab.components.ImageWithBottomDivider
import com.example.composebasicslab.components.ImageWithBottomTextBox
import com.example.composebasicslab.components.ImageWithCircleShapeAndShadow
import com.example.composebasicslab.components.ImageWithErrorAndPlaceholder
import com.example.composebasicslab.components.ImageWithOverlayText
import com.example.composebasicslab.components.InteractiveCardWithButton
import com.example.composebasicslab.components.LayeredTextBox
import com.example.composebasicslab.components.LivePreviewText
import com.example.composebasicslab.components.NameInputField_Outlined
import com.example.composebasicslab.components.NameInputField_TextField
import com.example.composebasicslab.components.NameListWithIndex
import com.example.composebasicslab.components.NumberedCardList
import com.example.composebasicslab.components.PizzaSizeSelector
import com.example.composebasicslab.components.RoundedImageWithBorder
import com.example.composebasicslab.components.SearchBarWithFilter
import com.example.composebasicslab.components.SimpleButtonExample
import com.example.composebasicslab.components.SimpleCardList
import com.example.composebasicslab.components.SimpleCounter
import com.example.composebasicslab.components.SimpleGrid
import com.example.composebasicslab.components.SimpleStarIcon
import com.example.composebasicslab.components.SimpleTextCard
import com.example.composebasicslab.components.StyledGrid
import com.example.composebasicslab.components.TaskCheckbox
import com.example.composebasicslab.components.TaskListWithIcons
import com.example.composebasicslab.components.TextSpacerColumn
import com.example.composebasicslab.components.TextWithButtonColumn
import com.example.composebasicslab.components.TextWithDivider
import com.example.composebasicslab.components.ToggleButton
import com.example.composebasicslab.components.TwoButtonColumn
import com.example.composebasicslab.components.VerticalIconsColumn
import com.example.composebasicslab.components.VerticalImageCard
import com.example.composebasicslab.components.VerticalTextColumn
import com.example.composebasicslab.ui.theme.ComposeBasicsLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBasicsLabTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .background(color = Color.White),
                        contentAlignment = Alignment.Center
                    ){
//                            SimpleButtonExample()
//                            TwoButtonColumn()

//                        ButtonRowExample()
//                        FavoriteIconButton()
//                        DisabledButtonExample()
//                        FloatingActionButtonExample()

//                        Column (modifier = Modifier.padding(50.dp))
//                        {
//                            NameInputField_TextField()
//                            NameInputField_Outlined()
//                        }

//                        CommentBox()
//                        SearchBarWithFilter()

//                        BasicAsyncImage()
//                        RoundedImageWithBorder()
//                        ImageWithOverlayText()
//                        ImageWithCircleShapeAndShadow()
//                        ImageWithErrorAndPlaceholder()

//                        SimpleStarIcon()
//                        HorizontalIconRow()
//                        ClickableFavoriteIcon()
//                        FavoriteIconSelector()

//                        HorizontalTextRow()
//                        IconWithTextRow()
//                        ButtonRow()

//                        VerticalTextColumn()
//                        TextWithButtonColumn()
//                        VerticalIconsColumn()

//                        LayeredTextBox()
//                        ImageWithBottomTextBox()
//                        FloatingButtonBox()

//                        TextSpacerColumn()
//                        IconSpacerRow()
//                        CenteredButtonWithSpacer()

//                        TextWithDivider()
//                        ButtonDividerColumn()
//                        ImageWithBottomDivider()

//                        FruitListScreen()
//                        NameListWithIndex()
//                        TaskListWithIcons()
//                        AlternatingBackgroundList()

//                        SimpleTextCard()
//                        IconTextCard()
//                        InteractiveCardWithButton()
//                        SimpleCardList()
//                        NumberedCardList()
//                        ColoredCardList()
//                        VerticalImageCard()
//                        HorizontalImageCard()
//                        ImageCardList()
//                        SimpleGrid()
//                        AdaptiveGrid()
//                        StyledGrid()
//                        SimpleCounter()
//                        ToggleButton()
//                        LivePreviewText()
//                        TaskCheckbox()
//                        DarkModeSwitch()
                        PizzaSizeSelector()

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeBasicsLabTheme {
        Greeting("Android")
    }
}